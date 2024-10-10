package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MandatoryEarlyTermination;
import fpml.confirmation.MandatoryEarlyTerminationModel;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MandatoryEarlyTerminationModelValidator implements Validator<MandatoryEarlyTerminationModel> {

	private List<ComparisonResult> getComparisonResults(MandatoryEarlyTerminationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mandatoryEarlyTermination", (MandatoryEarlyTermination) o.getMandatoryEarlyTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryEarlyTerminationModelSequence", (MandatoryEarlyTerminationModelSequence) o.getMandatoryEarlyTerminationModelSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MandatoryEarlyTerminationModel> validate(RosettaPath path, MandatoryEarlyTerminationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MandatoryEarlyTerminationModel", ValidationType.CARDINALITY, "MandatoryEarlyTerminationModel", path, "", error);
		}
		return success("MandatoryEarlyTerminationModel", ValidationType.CARDINALITY, "MandatoryEarlyTerminationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MandatoryEarlyTerminationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MandatoryEarlyTerminationModel", ValidationType.CARDINALITY, "MandatoryEarlyTerminationModel", path, "", res.getError());
				}
				return success("MandatoryEarlyTerminationModel", ValidationType.CARDINALITY, "MandatoryEarlyTerminationModel", path, "");
			})
			.collect(toList());
	}

}
