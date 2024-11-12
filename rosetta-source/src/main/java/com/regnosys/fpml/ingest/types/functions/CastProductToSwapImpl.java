package com.regnosys.fpml.ingest.types.functions;

import fpml.confirmation.Product;
import fpml.confirmation.Swap;
import fpml.ingest.types.functions.CastProductToSwap;

import java.util.Optional;

public class CastProductToSwapImpl extends CastProductToSwap {
    @Override
    protected Swap.SwapBuilder doEvaluate(Product fpmlProduct) {
        return (Swap.SwapBuilder) Optional.ofNullable(fpmlProduct)
                .map(Product::toBuilder)
                .filter(x -> x instanceof Swap.SwapBuilder)
                .orElse(null);
    }
}
