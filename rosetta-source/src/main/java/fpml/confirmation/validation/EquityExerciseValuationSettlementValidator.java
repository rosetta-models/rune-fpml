package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.Currency;
import fpml.confirmation.EquityAmericanExercise;
import fpml.confirmation.EquityBermudaExercise;
import fpml.confirmation.EquityEuropeanExercise;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityExerciseValuationSettlementSequence;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PrePayment;
import fpml.confirmation.SettlementPriceDefaultElection;
import fpml.confirmation.SettlementPriceSource;
import fpml.confirmation.SettlementTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityExerciseValuationSettlementValidator implements Validator<EquityExerciseValuationSettlement> {

	private List<ComparisonResult> getComparisonResults(EquityExerciseValuationSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("equityEuropeanExercise", (EquityEuropeanExercise) o.getEquityEuropeanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityAmericanExercise", (EquityAmericanExercise) o.getEquityAmericanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityBermudaExercise", (EquityBermudaExercise) o.getEquityBermudaExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExerciseValuationSettlementSequence", (EquityExerciseValuationSettlementSequence) o.getEquityExerciseValuationSettlementSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("prePayment", (PrePayment) o.getPrePayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityValuation", (EquityValuation) o.getEquityValuation() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementPriceSource", (SettlementPriceSource) o.getSettlementPriceSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementMethodElectionDate", (AdjustableOrRelativeDate) o.getSettlementMethodElectionDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementMethodElectingPartyReference", (PartyReference) o.getSettlementMethodElectingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPriceDefaultElection", (SettlementPriceDefaultElection) o.getSettlementPriceDefaultElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityExerciseValuationSettlement> validate(RosettaPath path, EquityExerciseValuationSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityExerciseValuationSettlement", ValidationType.CARDINALITY, "EquityExerciseValuationSettlement", path, "", error);
		}
		return success("EquityExerciseValuationSettlement", ValidationType.CARDINALITY, "EquityExerciseValuationSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExerciseValuationSettlement", ValidationType.CARDINALITY, "EquityExerciseValuationSettlement", path, "", res.getError());
				}
				return success("EquityExerciseValuationSettlement", ValidationType.CARDINALITY, "EquityExerciseValuationSettlement", path, "");
			})
			.collect(toList());
	}

}
