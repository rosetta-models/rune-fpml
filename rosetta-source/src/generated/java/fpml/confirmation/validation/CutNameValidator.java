package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CutName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CutNameValidator implements Validator<CutName> {

	private List<ComparisonResult> getComparisonResults(CutName o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("cutNameScheme", (String) o.getCutNameScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CutName> validate(RosettaPath path, CutName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CutName", ValidationType.CARDINALITY, "CutName", path, "", error);
		}
		return success("CutName", ValidationType.CARDINALITY, "CutName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CutName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CutName", ValidationType.CARDINALITY, "CutName", path, "", res.getError());
				}
				return success("CutName", ValidationType.CARDINALITY, "CutName", path, "");
			})
			.collect(toList());
	}

}
