package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DateOffset;
import fpml.confirmation.DateReference;
import fpml.confirmation.RelativeDateSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RelativeDateSequenceValidator implements Validator<RelativeDateSequence> {

	private List<ComparisonResult> getComparisonResults(RelativeDateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateRelativeTo", (DateReference) o.getDateRelativeTo() != null ? 1 : 0, 1, 1), 
				checkCardinality("dateOffset", (List<? extends DateOffset>) o.getDateOffset() == null ? 0 : ((List<? extends DateOffset>) o.getDateOffset()).size(), 1, 0), 
				checkCardinality("businessCentersOrReferenceModel", (BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RelativeDateSequence> validate(RosettaPath path, RelativeDateSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RelativeDateSequence", ValidationType.CARDINALITY, "RelativeDateSequence", path, "", error);
		}
		return success("RelativeDateSequence", ValidationType.CARDINALITY, "RelativeDateSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativeDateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelativeDateSequence", ValidationType.CARDINALITY, "RelativeDateSequence", path, "", res.getError());
				}
				return success("RelativeDateSequence", ValidationType.CARDINALITY, "RelativeDateSequence", path, "");
			})
			.collect(toList());
	}

}
