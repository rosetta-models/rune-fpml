package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MasterConfirmation;
import fpml.confirmation.MasterConfirmationAnnexType;
import fpml.confirmation.MasterConfirmationType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MasterConfirmationValidator implements Validator<MasterConfirmation> {

	private List<ComparisonResult> getComparisonResults(MasterConfirmation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterConfirmationType", (MasterConfirmationType) o.getMasterConfirmationType() != null ? 1 : 0, 1, 1), 
				checkCardinality("masterConfirmationDate", (Date) o.getMasterConfirmationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("masterConfirmationAnnexDate", (Date) o.getMasterConfirmationAnnexDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterConfirmationAnnexType", (MasterConfirmationAnnexType) o.getMasterConfirmationAnnexType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MasterConfirmation> validate(RosettaPath path, MasterConfirmation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MasterConfirmation", ValidationType.CARDINALITY, "MasterConfirmation", path, "", error);
		}
		return success("MasterConfirmation", ValidationType.CARDINALITY, "MasterConfirmation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterConfirmation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterConfirmation", ValidationType.CARDINALITY, "MasterConfirmation", path, "", res.getError());
				}
				return success("MasterConfirmation", ValidationType.CARDINALITY, "MasterConfirmation", path, "");
			})
			.collect(toList());
	}

}
