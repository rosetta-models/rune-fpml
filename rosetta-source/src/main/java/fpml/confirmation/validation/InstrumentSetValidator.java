package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InstrumentSet;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentSetValidator implements Validator<InstrumentSet> {

	private List<ComparisonResult> getComparisonResults(InstrumentSet o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InstrumentSet> validate(RosettaPath path, InstrumentSet o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentSet", ValidationType.CARDINALITY, "InstrumentSet", path, "", error);
		}
		return success("InstrumentSet", ValidationType.CARDINALITY, "InstrumentSet", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentSet", ValidationType.CARDINALITY, "InstrumentSet", path, "", res.getError());
				}
				return success("InstrumentSet", ValidationType.CARDINALITY, "InstrumentSet", path, "");
			})
			.collect(toList());
	}

}
