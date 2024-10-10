package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendLegTypeFormatValidator implements Validator<DividendLeg> {

	private List<ComparisonResult> getComparisonResults(DividendLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DividendLeg> validate(RosettaPath path, DividendLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendLeg", ValidationType.TYPE_FORMAT, "DividendLeg", path, "", error);
		}
		return success("DividendLeg", ValidationType.TYPE_FORMAT, "DividendLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendLeg", ValidationType.TYPE_FORMAT, "DividendLeg", path, "", res.getError());
				}
				return success("DividendLeg", ValidationType.TYPE_FORMAT, "DividendLeg", path, "");
			})
			.collect(toList());
	}

}
