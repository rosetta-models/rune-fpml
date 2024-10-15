package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCrossRateObservableValidator implements Validator<FxCrossRateObservable> {

	private List<ComparisonResult> getComparisonResults(FxCrossRateObservable o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("informationSource", (FxInformationSource) o.getInformationSource() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxCrossRateObservable> validate(RosettaPath path, FxCrossRateObservable o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCrossRateObservable", ValidationType.CARDINALITY, "FxCrossRateObservable", path, "", error);
		}
		return success("FxCrossRateObservable", ValidationType.CARDINALITY, "FxCrossRateObservable", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCrossRateObservable o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCrossRateObservable", ValidationType.CARDINALITY, "FxCrossRateObservable", path, "", res.getError());
				}
				return success("FxCrossRateObservable", ValidationType.CARDINALITY, "FxCrossRateObservable", path, "");
			})
			.collect(toList());
	}

}
