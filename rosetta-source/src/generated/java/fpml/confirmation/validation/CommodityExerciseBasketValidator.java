package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityAmericanExercise;
import fpml.confirmation.CommodityEuropeanExercise;
import fpml.confirmation.CommodityExerciseBasket;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.IdentifiedCurrency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityExerciseBasketValidator implements Validator<CommodityExerciseBasket> {

	private List<ComparisonResult> getComparisonResults(CommodityExerciseBasket o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("americanExercise", (CommodityAmericanExercise) o.getAmericanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("europeanExercise", (CommodityEuropeanExercise) o.getEuropeanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("automaticExercise", (Boolean) o.getAutomaticExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("writtenConfirmation", (Boolean) o.getWrittenConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (IdentifiedCurrency) o.getSettlementCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityPaymentDatesModel", (CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityExerciseBasket> validate(RosettaPath path, CommodityExerciseBasket o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityExerciseBasket", ValidationType.CARDINALITY, "CommodityExerciseBasket", path, "", error);
		}
		return success("CommodityExerciseBasket", ValidationType.CARDINALITY, "CommodityExerciseBasket", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityExerciseBasket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityExerciseBasket", ValidationType.CARDINALITY, "CommodityExerciseBasket", path, "", res.getError());
				}
				return success("CommodityExerciseBasket", ValidationType.CARDINALITY, "CommodityExerciseBasket", path, "");
			})
			.collect(toList());
	}

}
