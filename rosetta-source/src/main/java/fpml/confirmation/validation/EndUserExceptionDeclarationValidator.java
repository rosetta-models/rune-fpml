package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EndUserExceptionDeclaration;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EndUserExceptionDeclarationValidator implements Validator<EndUserExceptionDeclaration> {

	private List<ComparisonResult> getComparisonResults(EndUserExceptionDeclaration o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EndUserExceptionDeclaration> validate(RosettaPath path, EndUserExceptionDeclaration o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EndUserExceptionDeclaration", ValidationType.CARDINALITY, "EndUserExceptionDeclaration", path, "", error);
		}
		return success("EndUserExceptionDeclaration", ValidationType.CARDINALITY, "EndUserExceptionDeclaration", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EndUserExceptionDeclaration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EndUserExceptionDeclaration", ValidationType.CARDINALITY, "EndUserExceptionDeclaration", path, "", res.getError());
				}
				return success("EndUserExceptionDeclaration", ValidationType.CARDINALITY, "EndUserExceptionDeclaration", path, "");
			})
			.collect(toList());
	}

}
