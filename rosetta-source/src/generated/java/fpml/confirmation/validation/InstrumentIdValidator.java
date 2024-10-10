package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InstrumentId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentIdValidator implements Validator<InstrumentId> {

	private List<ComparisonResult> getComparisonResults(InstrumentId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("instrumentIdScheme", (String) o.getInstrumentIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<InstrumentId> validate(RosettaPath path, InstrumentId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentId", ValidationType.CARDINALITY, "InstrumentId", path, "", error);
		}
		return success("InstrumentId", ValidationType.CARDINALITY, "InstrumentId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentId", ValidationType.CARDINALITY, "InstrumentId", path, "", res.getError());
				}
				return success("InstrumentId", ValidationType.CARDINALITY, "InstrumentId", path, "");
			})
			.collect(toList());
	}

}
