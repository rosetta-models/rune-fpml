package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.SettlementInstruction;
import fpml.confirmation.SettlementInstructionId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementDetailsValidator implements Validator<SettlementDetails> {

	private List<ComparisonResult> getComparisonResults(SettlementDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (SettlementInstructionId) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementInstruction", (SettlementInstruction) o.getSettlementInstruction() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SettlementDetails> validate(RosettaPath path, SettlementDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementDetails", ValidationType.CARDINALITY, "SettlementDetails", path, "", error);
		}
		return success("SettlementDetails", ValidationType.CARDINALITY, "SettlementDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementDetails", ValidationType.CARDINALITY, "SettlementDetails", path, "", res.getError());
				}
				return success("SettlementDetails", ValidationType.CARDINALITY, "SettlementDetails", path, "");
			})
			.collect(toList());
	}

}
