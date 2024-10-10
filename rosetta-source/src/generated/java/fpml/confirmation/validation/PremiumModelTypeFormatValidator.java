package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PremiumModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PremiumModelTypeFormatValidator implements Validator<PremiumModel> {

	private List<ComparisonResult> getComparisonResults(PremiumModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PremiumModel> validate(RosettaPath path, PremiumModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PremiumModel", ValidationType.TYPE_FORMAT, "PremiumModel", path, "", error);
		}
		return success("PremiumModel", ValidationType.TYPE_FORMAT, "PremiumModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PremiumModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PremiumModel", ValidationType.TYPE_FORMAT, "PremiumModel", path, "", res.getError());
				}
				return success("PremiumModel", ValidationType.TYPE_FORMAT, "PremiumModel", path, "");
			})
			.collect(toList());
	}

}
