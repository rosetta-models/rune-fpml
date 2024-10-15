package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NoFaultTermination;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NoFaultTerminationValidator implements Validator<NoFaultTermination> {

	private List<ComparisonResult> getComparisonResults(NoFaultTermination o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NoFaultTermination> validate(RosettaPath path, NoFaultTermination o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NoFaultTermination", ValidationType.CARDINALITY, "NoFaultTermination", path, "", error);
		}
		return success("NoFaultTermination", ValidationType.CARDINALITY, "NoFaultTermination", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoFaultTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoFaultTermination", ValidationType.CARDINALITY, "NoFaultTermination", path, "", res.getError());
				}
				return success("NoFaultTermination", ValidationType.CARDINALITY, "NoFaultTermination", path, "");
			})
			.collect(toList());
	}

}
