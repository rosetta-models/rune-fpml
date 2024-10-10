package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SinglePartyOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SinglePartyOptionTypeFormatValidator implements Validator<SinglePartyOption> {

	private List<ComparisonResult> getComparisonResults(SinglePartyOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SinglePartyOption> validate(RosettaPath path, SinglePartyOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SinglePartyOption", ValidationType.TYPE_FORMAT, "SinglePartyOption", path, "", error);
		}
		return success("SinglePartyOption", ValidationType.TYPE_FORMAT, "SinglePartyOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SinglePartyOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SinglePartyOption", ValidationType.TYPE_FORMAT, "SinglePartyOption", path, "", res.getError());
				}
				return success("SinglePartyOption", ValidationType.TYPE_FORMAT, "SinglePartyOption", path, "");
			})
			.collect(toList());
	}

}
