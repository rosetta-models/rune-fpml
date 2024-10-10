package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxSwap;
import fpml.confirmation.FxSwapLeg;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxSwapValidator implements Validator<FxSwap> {

	private List<ComparisonResult> getComparisonResults(FxSwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("nearLeg", (FxSwapLeg) o.getNearLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("farLeg", (FxSwapLeg) o.getFarLeg() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxSwap> validate(RosettaPath path, FxSwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxSwap", ValidationType.CARDINALITY, "FxSwap", path, "", error);
		}
		return success("FxSwap", ValidationType.CARDINALITY, "FxSwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSwap", ValidationType.CARDINALITY, "FxSwap", path, "", res.getError());
				}
				return success("FxSwap", ValidationType.CARDINALITY, "FxSwap", path, "");
			})
			.collect(toList());
	}

}
