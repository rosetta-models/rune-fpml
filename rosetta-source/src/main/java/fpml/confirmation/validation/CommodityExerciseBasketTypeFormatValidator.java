package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityExerciseBasket;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityExerciseBasketTypeFormatValidator implements Validator<CommodityExerciseBasket> {

	private List<ComparisonResult> getComparisonResults(CommodityExerciseBasket o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityExerciseBasket> validate(RosettaPath path, CommodityExerciseBasket o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityExerciseBasket", ValidationType.TYPE_FORMAT, "CommodityExerciseBasket", path, "", error);
		}
		return success("CommodityExerciseBasket", ValidationType.TYPE_FORMAT, "CommodityExerciseBasket", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityExerciseBasket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityExerciseBasket", ValidationType.TYPE_FORMAT, "CommodityExerciseBasket", path, "", res.getError());
				}
				return success("CommodityExerciseBasket", ValidationType.TYPE_FORMAT, "CommodityExerciseBasket", path, "");
			})
			.collect(toList());
	}

}
