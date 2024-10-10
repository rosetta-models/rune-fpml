package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AffectedTransactions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AffectedTransactionsTypeFormatValidator implements Validator<AffectedTransactions> {

	private List<ComparisonResult> getComparisonResults(AffectedTransactions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AffectedTransactions> validate(RosettaPath path, AffectedTransactions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AffectedTransactions", ValidationType.TYPE_FORMAT, "AffectedTransactions", path, "", error);
		}
		return success("AffectedTransactions", ValidationType.TYPE_FORMAT, "AffectedTransactions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AffectedTransactions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AffectedTransactions", ValidationType.TYPE_FORMAT, "AffectedTransactions", path, "", res.getError());
				}
				return success("AffectedTransactions", ValidationType.TYPE_FORMAT, "AffectedTransactions", path, "");
			})
			.collect(toList());
	}

}
