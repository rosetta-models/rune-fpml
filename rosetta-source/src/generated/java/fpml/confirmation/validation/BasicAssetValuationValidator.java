package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.BasicAssetValuation;
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.ValuationScenarioReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasicAssetValuationValidator implements Validator<BasicAssetValuation> {

	private List<ComparisonResult> getComparisonResults(BasicAssetValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("objectReference", (AnyAssetReference) o.getObjectReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationScenarioReference", (ValuationScenarioReference) o.getValuationScenarioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("definitionRef", (String) o.getDefinitionRef() != null ? 1 : 0, 0, 1), 
				checkCardinality("quote", (List<? extends BasicQuotation>) o.getQuote() == null ? 0 : ((List<? extends BasicQuotation>) o.getQuote()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<BasicAssetValuation> validate(RosettaPath path, BasicAssetValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasicAssetValuation", ValidationType.CARDINALITY, "BasicAssetValuation", path, "", error);
		}
		return success("BasicAssetValuation", ValidationType.CARDINALITY, "BasicAssetValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasicAssetValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasicAssetValuation", ValidationType.CARDINALITY, "BasicAssetValuation", path, "", res.getError());
				}
				return success("BasicAssetValuation", ValidationType.CARDINALITY, "BasicAssetValuation", path, "");
			})
			.collect(toList());
	}

}
