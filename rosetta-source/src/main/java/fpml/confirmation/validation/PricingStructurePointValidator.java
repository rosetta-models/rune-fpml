package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingStructurePoint;
import fpml.confirmation.QuotationModel;
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingStructurePointValidator implements Validator<PricingStructurePoint> {

	private List<ComparisonResult> getComparisonResults(PricingStructurePoint o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("underlyingAssetOrReferenceModel", (UnderlyingAssetOrReferenceModel) o.getUnderlyingAssetOrReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationModel", (QuotationModel) o.getQuotationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PricingStructurePoint> validate(RosettaPath path, PricingStructurePoint o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingStructurePoint", ValidationType.CARDINALITY, "PricingStructurePoint", path, "", error);
		}
		return success("PricingStructurePoint", ValidationType.CARDINALITY, "PricingStructurePoint", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructurePoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingStructurePoint", ValidationType.CARDINALITY, "PricingStructurePoint", path, "", res.getError());
				}
				return success("PricingStructurePoint", ValidationType.CARDINALITY, "PricingStructurePoint", path, "");
			})
			.collect(toList());
	}

}
