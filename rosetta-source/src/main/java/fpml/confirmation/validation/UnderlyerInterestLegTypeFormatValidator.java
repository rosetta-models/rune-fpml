package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UnderlyerInterestLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnderlyerInterestLegTypeFormatValidator implements Validator<UnderlyerInterestLeg> {

	private List<ComparisonResult> getComparisonResults(UnderlyerInterestLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<UnderlyerInterestLeg> validate(RosettaPath path, UnderlyerInterestLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UnderlyerInterestLeg", ValidationType.TYPE_FORMAT, "UnderlyerInterestLeg", path, "", error);
		}
		return success("UnderlyerInterestLeg", ValidationType.TYPE_FORMAT, "UnderlyerInterestLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyerInterestLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyerInterestLeg", ValidationType.TYPE_FORMAT, "UnderlyerInterestLeg", path, "", res.getError());
				}
				return success("UnderlyerInterestLeg", ValidationType.TYPE_FORMAT, "UnderlyerInterestLeg", path, "");
			})
			.collect(toList());
	}

}
