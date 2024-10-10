package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CancelableProvision;
import fpml.confirmation.EarlyTerminationProvision;
import fpml.confirmation.ExtendibleProvision;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Swap;
import fpml.confirmation.SwapAdditionalTerms;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwapValidator implements Validator<Swap> {

	private List<ComparisonResult> getComparisonResults(Swap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("swapStream", (List<? extends InterestRateStream>) o.getSwapStream() == null ? 0 : ((List<? extends InterestRateStream>) o.getSwapStream()).size(), 1, 0), 
				checkCardinality("earlyTerminationProvision", (EarlyTerminationProvision) o.getEarlyTerminationProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("cancelableProvision", (CancelableProvision) o.getCancelableProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("extendibleProvision", (ExtendibleProvision) o.getExtendibleProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalTerms", (SwapAdditionalTerms) o.getAdditionalTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Swap> validate(RosettaPath path, Swap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Swap", ValidationType.CARDINALITY, "Swap", path, "", error);
		}
		return success("Swap", ValidationType.CARDINALITY, "Swap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Swap", ValidationType.CARDINALITY, "Swap", path, "", res.getError());
				}
				return success("Swap", ValidationType.CARDINALITY, "Swap", path, "");
			})
			.collect(toList());
	}

}
