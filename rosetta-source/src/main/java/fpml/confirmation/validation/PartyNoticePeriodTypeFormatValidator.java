package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyNoticePeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyNoticePeriodTypeFormatValidator implements Validator<PartyNoticePeriod> {

	private List<ComparisonResult> getComparisonResults(PartyNoticePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyNoticePeriod> validate(RosettaPath path, PartyNoticePeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyNoticePeriod", ValidationType.TYPE_FORMAT, "PartyNoticePeriod", path, "", error);
		}
		return success("PartyNoticePeriod", ValidationType.TYPE_FORMAT, "PartyNoticePeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyNoticePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyNoticePeriod", ValidationType.TYPE_FORMAT, "PartyNoticePeriod", path, "", res.getError());
				}
				return success("PartyNoticePeriod", ValidationType.TYPE_FORMAT, "PartyNoticePeriod", path, "");
			})
			.collect(toList());
	}

}
