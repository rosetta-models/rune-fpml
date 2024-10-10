package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.MarketReference;
import fpml.confirmation.ValuationScenario;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValuationScenarioValidator implements Validator<ValuationScenario> {

	private List<ComparisonResult> getComparisonResults(ValuationScenario o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDate", (IdentifiedDate) o.getValuationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("marketReference", (MarketReference) o.getMarketReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ValuationScenario> validate(RosettaPath path, ValuationScenario o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ValuationScenario", ValidationType.CARDINALITY, "ValuationScenario", path, "", error);
		}
		return success("ValuationScenario", ValidationType.CARDINALITY, "ValuationScenario", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationScenario o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationScenario", ValidationType.CARDINALITY, "ValuationScenario", path, "", res.getError());
				}
				return success("ValuationScenario", ValidationType.CARDINALITY, "ValuationScenario", path, "");
			})
			.collect(toList());
	}

}
