package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DSAKeyValue;
import fpml.confirmation.DSAKeyValueTypeSequence0;
import fpml.confirmation.DSAKeyValueTypeSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DSAKeyValueValidator implements Validator<DSAKeyValue> {

	private List<ComparisonResult> getComparisonResults(DSAKeyValue o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dsaKeyValueTypeSequence0", (DSAKeyValueTypeSequence0) o.getDsaKeyValueTypeSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("g", (String) o.getG() != null ? 1 : 0, 0, 1), 
				checkCardinality("y", (String) o.getY() != null ? 1 : 0, 1, 1), 
				checkCardinality("j", (String) o.getJ() != null ? 1 : 0, 0, 1), 
				checkCardinality("dsaKeyValueTypeSequence1", (DSAKeyValueTypeSequence1) o.getDsaKeyValueTypeSequence1() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DSAKeyValue> validate(RosettaPath path, DSAKeyValue o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DSAKeyValue", ValidationType.CARDINALITY, "DSAKeyValue", path, "", error);
		}
		return success("DSAKeyValue", ValidationType.CARDINALITY, "DSAKeyValue", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DSAKeyValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DSAKeyValue", ValidationType.CARDINALITY, "DSAKeyValue", path, "", res.getError());
				}
				return success("DSAKeyValue", ValidationType.CARDINALITY, "DSAKeyValue", path, "");
			})
			.collect(toList());
	}

}
