package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BondOptionStrike;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BondOptionStrikeTypeFormatValidator implements Validator<BondOptionStrike> {

	private List<ComparisonResult> getComparisonResults(BondOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BondOptionStrike> validate(RosettaPath path, BondOptionStrike o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BondOptionStrike", ValidationType.TYPE_FORMAT, "BondOptionStrike", path, "", error);
		}
		return success("BondOptionStrike", ValidationType.TYPE_FORMAT, "BondOptionStrike", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BondOptionStrike", ValidationType.TYPE_FORMAT, "BondOptionStrike", path, "", res.getError());
				}
				return success("BondOptionStrike", ValidationType.TYPE_FORMAT, "BondOptionStrike", path, "");
			})
			.collect(toList());
	}

}
