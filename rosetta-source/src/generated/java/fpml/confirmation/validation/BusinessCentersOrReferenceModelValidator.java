package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenters;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessCentersReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BusinessCentersOrReferenceModelValidator implements Validator<BusinessCentersOrReferenceModel> {

	private List<ComparisonResult> getComparisonResults(BusinessCentersOrReferenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BusinessCentersOrReferenceModel> validate(RosettaPath path, BusinessCentersOrReferenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BusinessCentersOrReferenceModel", ValidationType.CARDINALITY, "BusinessCentersOrReferenceModel", path, "", error);
		}
		return success("BusinessCentersOrReferenceModel", ValidationType.CARDINALITY, "BusinessCentersOrReferenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCentersOrReferenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessCentersOrReferenceModel", ValidationType.CARDINALITY, "BusinessCentersOrReferenceModel", path, "", res.getError());
				}
				return success("BusinessCentersOrReferenceModel", ValidationType.CARDINALITY, "BusinessCentersOrReferenceModel", path, "");
			})
			.collect(toList());
	}

}
