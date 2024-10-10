package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxStraddlePremium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxStraddlePremiumTypeFormatValidator implements Validator<FxStraddlePremium> {

	private List<ComparisonResult> getComparisonResults(FxStraddlePremium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxStraddlePremium> validate(RosettaPath path, FxStraddlePremium o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxStraddlePremium", ValidationType.TYPE_FORMAT, "FxStraddlePremium", path, "", error);
		}
		return success("FxStraddlePremium", ValidationType.TYPE_FORMAT, "FxStraddlePremium", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxStraddlePremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxStraddlePremium", ValidationType.TYPE_FORMAT, "FxStraddlePremium", path, "", res.getError());
				}
				return success("FxStraddlePremium", ValidationType.TYPE_FORMAT, "FxStraddlePremium", path, "");
			})
			.collect(toList());
	}

}
