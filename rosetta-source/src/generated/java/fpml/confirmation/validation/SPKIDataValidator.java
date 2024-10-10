package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SPKIData;
import fpml.confirmation.SPKIDataTypeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SPKIDataValidator implements Validator<SPKIData> {

	private List<ComparisonResult> getComparisonResults(SPKIData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spkiDataTypeSequence", (List<? extends SPKIDataTypeSequence>) o.getSpkiDataTypeSequence() == null ? 0 : ((List<? extends SPKIDataTypeSequence>) o.getSpkiDataTypeSequence()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<SPKIData> validate(RosettaPath path, SPKIData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SPKIData", ValidationType.CARDINALITY, "SPKIData", path, "", error);
		}
		return success("SPKIData", ValidationType.CARDINALITY, "SPKIData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SPKIData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SPKIData", ValidationType.CARDINALITY, "SPKIData", path, "", res.getError());
				}
				return success("SPKIData", ValidationType.CARDINALITY, "SPKIData", path, "");
			})
			.collect(toList());
	}

}
