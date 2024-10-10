package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbsoluteTolerance;
import fpml.confirmation.OilDelivery;
import fpml.confirmation.OilPipelineDelivery;
import fpml.confirmation.OilTransferDelivery;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PercentageTolerance;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OilDeliveryValidator implements Validator<OilDelivery> {

	private List<ComparisonResult> getComparisonResults(OilDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pipeline", (OilPipelineDelivery) o.getPipeline() != null ? 1 : 0, 0, 1), 
				checkCardinality("transfer", (OilTransferDelivery) o.getTransfer() != null ? 1 : 0, 0, 1), 
				checkCardinality("importerOfRecord", (PartyReference) o.getImporterOfRecord() != null ? 1 : 0, 0, 1), 
				checkCardinality("absoluteTolerance", (AbsoluteTolerance) o.getAbsoluteTolerance() != null ? 1 : 0, 0, 1), 
				checkCardinality("percentageTolerance", (PercentageTolerance) o.getPercentageTolerance() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OilDelivery> validate(RosettaPath path, OilDelivery o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OilDelivery", ValidationType.CARDINALITY, "OilDelivery", path, "", error);
		}
		return success("OilDelivery", ValidationType.CARDINALITY, "OilDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilDelivery", ValidationType.CARDINALITY, "OilDelivery", path, "", res.getError());
				}
				return success("OilDelivery", ValidationType.CARDINALITY, "OilDelivery", path, "");
			})
			.collect(toList());
	}

}
