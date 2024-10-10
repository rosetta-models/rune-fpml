package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PGPData;
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.PGPDataTypeSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PGPDataValidator implements Validator<PGPData> {

	private List<ComparisonResult> getComparisonResults(PGPData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pgpDataTypeSequence0", (PGPDataTypeSequence0) o.getPgpDataTypeSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("pgpDataTypeSequence1", (PGPDataTypeSequence1) o.getPgpDataTypeSequence1() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PGPData> validate(RosettaPath path, PGPData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PGPData", ValidationType.CARDINALITY, "PGPData", path, "", error);
		}
		return success("PGPData", ValidationType.CARDINALITY, "PGPData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PGPData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PGPData", ValidationType.CARDINALITY, "PGPData", path, "", res.getError());
				}
				return success("PGPData", ValidationType.CARDINALITY, "PGPData", path, "");
			})
			.collect(toList());
	}

}
