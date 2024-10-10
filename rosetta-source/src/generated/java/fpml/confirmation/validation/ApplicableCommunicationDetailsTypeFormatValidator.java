package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApplicableCommunicationDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApplicableCommunicationDetailsTypeFormatValidator implements Validator<ApplicableCommunicationDetails> {

	private List<ComparisonResult> getComparisonResults(ApplicableCommunicationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ApplicableCommunicationDetails> validate(RosettaPath path, ApplicableCommunicationDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ApplicableCommunicationDetails", ValidationType.TYPE_FORMAT, "ApplicableCommunicationDetails", path, "", error);
		}
		return success("ApplicableCommunicationDetails", ValidationType.TYPE_FORMAT, "ApplicableCommunicationDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableCommunicationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableCommunicationDetails", ValidationType.TYPE_FORMAT, "ApplicableCommunicationDetails", path, "", res.getError());
				}
				return success("ApplicableCommunicationDetails", ValidationType.TYPE_FORMAT, "ApplicableCommunicationDetails", path, "");
			})
			.collect(toList());
	}

}
