package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AlgorithmRole;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AlgorithmRoleTypeFormatValidator implements Validator<AlgorithmRole> {

	private List<ComparisonResult> getComparisonResults(AlgorithmRole o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("algorithmRoleScheme", o.getAlgorithmRoleScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<AlgorithmRole> validate(RosettaPath path, AlgorithmRole o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AlgorithmRole", ValidationType.TYPE_FORMAT, "AlgorithmRole", path, "", error);
		}
		return success("AlgorithmRole", ValidationType.TYPE_FORMAT, "AlgorithmRole", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AlgorithmRole o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AlgorithmRole", ValidationType.TYPE_FORMAT, "AlgorithmRole", path, "", res.getError());
				}
				return success("AlgorithmRole", ValidationType.TYPE_FORMAT, "AlgorithmRole", path, "");
			})
			.collect(toList());
	}

}
