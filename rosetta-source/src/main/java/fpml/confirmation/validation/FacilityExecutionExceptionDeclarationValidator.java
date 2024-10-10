package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityExecutionExceptionDeclaration;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityExecutionExceptionDeclarationValidator implements Validator<FacilityExecutionExceptionDeclaration> {

	private List<ComparisonResult> getComparisonResults(FacilityExecutionExceptionDeclaration o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityExecutionExceptionDeclaration> validate(RosettaPath path, FacilityExecutionExceptionDeclaration o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityExecutionExceptionDeclaration", ValidationType.CARDINALITY, "FacilityExecutionExceptionDeclaration", path, "", error);
		}
		return success("FacilityExecutionExceptionDeclaration", ValidationType.CARDINALITY, "FacilityExecutionExceptionDeclaration", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityExecutionExceptionDeclaration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityExecutionExceptionDeclaration", ValidationType.CARDINALITY, "FacilityExecutionExceptionDeclaration", path, "", res.getError());
				}
				return success("FacilityExecutionExceptionDeclaration", ValidationType.CARDINALITY, "FacilityExecutionExceptionDeclaration", path, "");
			})
			.collect(toList());
	}

}
