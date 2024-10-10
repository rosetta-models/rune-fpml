package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransactionCharacteristic;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransactionCharacteristicValidator implements Validator<TransactionCharacteristic> {

	private List<ComparisonResult> getComparisonResults(TransactionCharacteristic o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("transactionCharacteristicScheme", (String) o.getTransactionCharacteristicScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TransactionCharacteristic> validate(RosettaPath path, TransactionCharacteristic o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransactionCharacteristic", ValidationType.CARDINALITY, "TransactionCharacteristic", path, "", error);
		}
		return success("TransactionCharacteristic", ValidationType.CARDINALITY, "TransactionCharacteristic", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactionCharacteristic o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactionCharacteristic", ValidationType.CARDINALITY, "TransactionCharacteristic", path, "", res.getError());
				}
				return success("TransactionCharacteristic", ValidationType.CARDINALITY, "TransactionCharacteristic", path, "");
			})
			.collect(toList());
	}

}
