package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.SupervisorRegistrationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SupervisorRegistrationValidator implements Validator<SupervisorRegistration> {

	private List<ComparisonResult> getComparisonResults(SupervisorRegistration o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("supervisorRegistrationModel", (SupervisorRegistrationModel) o.getSupervisorRegistrationModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SupervisorRegistration> validate(RosettaPath path, SupervisorRegistration o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SupervisorRegistration", ValidationType.CARDINALITY, "SupervisorRegistration", path, "", error);
		}
		return success("SupervisorRegistration", ValidationType.CARDINALITY, "SupervisorRegistration", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SupervisorRegistration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SupervisorRegistration", ValidationType.CARDINALITY, "SupervisorRegistration", path, "", res.getError());
				}
				return success("SupervisorRegistration", ValidationType.CARDINALITY, "SupervisorRegistration", path, "");
			})
			.collect(toList());
	}

}
