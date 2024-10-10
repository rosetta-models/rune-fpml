package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RegulatorId;
import fpml.confirmation.SupervisorRegistrationModel;
import fpml.confirmation.SupervisoryBody;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SupervisorRegistrationModelValidator implements Validator<SupervisorRegistrationModel> {

	private List<ComparisonResult> getComparisonResults(SupervisorRegistrationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("supervisoryBody", (SupervisoryBody) o.getSupervisoryBody() != null ? 1 : 0, 1, 1), 
				checkCardinality("registrationNumber", (RegulatorId) o.getRegistrationNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SupervisorRegistrationModel> validate(RosettaPath path, SupervisorRegistrationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SupervisorRegistrationModel", ValidationType.CARDINALITY, "SupervisorRegistrationModel", path, "", error);
		}
		return success("SupervisorRegistrationModel", ValidationType.CARDINALITY, "SupervisorRegistrationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SupervisorRegistrationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SupervisorRegistrationModel", ValidationType.CARDINALITY, "SupervisorRegistrationModel", path, "", res.getError());
				}
				return success("SupervisorRegistrationModel", ValidationType.CARDINALITY, "SupervisorRegistrationModel", path, "");
			})
			.collect(toList());
	}

}
