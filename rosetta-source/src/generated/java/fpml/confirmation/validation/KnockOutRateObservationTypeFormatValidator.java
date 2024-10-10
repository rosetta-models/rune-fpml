package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.KnockOutRateObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class KnockOutRateObservationTypeFormatValidator implements Validator<KnockOutRateObservation> {

	private List<ComparisonResult> getComparisonResults(KnockOutRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<KnockOutRateObservation> validate(RosettaPath path, KnockOutRateObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("KnockOutRateObservation", ValidationType.TYPE_FORMAT, "KnockOutRateObservation", path, "", error);
		}
		return success("KnockOutRateObservation", ValidationType.TYPE_FORMAT, "KnockOutRateObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KnockOutRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KnockOutRateObservation", ValidationType.TYPE_FORMAT, "KnockOutRateObservation", path, "", res.getError());
				}
				return success("KnockOutRateObservation", ValidationType.TYPE_FORMAT, "KnockOutRateObservation", path, "");
			})
			.collect(toList());
	}

}
