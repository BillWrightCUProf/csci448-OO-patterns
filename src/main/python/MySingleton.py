class MySingleton:

def __new__(cls, *args, **kwds):
        it = cls.__dict__.get("__it__")
        if it is not None:
            return it
        cls.__it__ = it = object.__new__(cls)
        it.init(*args, **kwds)
        return it

    def init(self, *args, **kwds):
        pass

#     _instance = None
#
#     def __new__(cls):
#         if cls._instance is None:
#             cls._instance = super().__new__(cls)
#         return cls._instance