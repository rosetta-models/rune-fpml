package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MortgageSector;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MortgageSectorValidator implements Validator<MortgageSector> {

	private List<ComparisonResult> getComparisonResults(MortgageSector o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("mortgageSectorScheme", (String) o.getMortgageSectorScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MortgageSector> validate(RosettaPath path, MortgageSector o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MortgageSector", ValidationType.CARDINALITY, "MortgageSector", path, "", error);
		}
		return success("MortgageSector", ValidationType.CARDINALITY, "MortgageSector", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MortgageSector o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MortgageSector", ValidationType.CARDINALITY, "MortgageSector", path, "", res.getError());
				}
				return success("MortgageSector", ValidationType.CARDINALITY, "MortgageSector", path, "");
			})
			.collect(toList());
	}

}
