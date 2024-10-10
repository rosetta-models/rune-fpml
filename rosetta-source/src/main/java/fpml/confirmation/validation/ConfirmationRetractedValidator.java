package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ConfirmationRetracted;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ConfirmationRetractedValidator implements Validator<ConfirmationRetracted> {

	private List<ComparisonResult> getComparisonResults(ConfirmationRetracted o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingAndPostTradeEventsModel", (TradingAndPostTradeEventsModel) o.getTradingAndPostTradeEventsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExercise", (OptionExercise) o.getOptionExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ConfirmationRetracted> validate(RosettaPath path, ConfirmationRetracted o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ConfirmationRetracted", ValidationType.CARDINALITY, "ConfirmationRetracted", path, "", error);
		}
		return success("ConfirmationRetracted", ValidationType.CARDINALITY, "ConfirmationRetracted", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConfirmationRetracted o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConfirmationRetracted", ValidationType.CARDINALITY, "ConfirmationRetracted", path, "", res.getError());
				}
				return success("ConfirmationRetracted", ValidationType.CARDINALITY, "ConfirmationRetracted", path, "");
			})
			.collect(toList());
	}

}
