package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BidMidAskModel;
import fpml.confirmation.TermPoint;
import fpml.confirmation.TimeDimension;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TermPointValidator implements Validator<TermPoint> {

	private List<ComparisonResult> getComparisonResults(TermPoint o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("term", (TimeDimension) o.getTerm() != null ? 1 : 0, 1, 1), 
				checkCardinality("bidMidAskModel", (BidMidAskModel) o.getBidMidAskModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("spreadValue", (BigDecimal) o.getSpreadValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (AssetReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TermPoint> validate(RosettaPath path, TermPoint o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TermPoint", ValidationType.CARDINALITY, "TermPoint", path, "", error);
		}
		return success("TermPoint", ValidationType.CARDINALITY, "TermPoint", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermPoint", ValidationType.CARDINALITY, "TermPoint", path, "", res.getError());
				}
				return success("TermPoint", ValidationType.CARDINALITY, "TermPoint", path, "");
			})
			.collect(toList());
	}

}
