package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Approvals;
import fpml.confirmation.PackageHeader;
import fpml.confirmation.TradePackage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradePackageValidator implements Validator<TradePackage> {

	private List<ComparisonResult> getComparisonResults(TradePackage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("packageHeader", (PackageHeader) o.getPackageHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvals", (Approvals) o.getApprovals() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradePackage> validate(RosettaPath path, TradePackage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradePackage", ValidationType.CARDINALITY, "TradePackage", path, "", error);
		}
		return success("TradePackage", ValidationType.CARDINALITY, "TradePackage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradePackage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradePackage", ValidationType.CARDINALITY, "TradePackage", path, "", res.getError());
				}
				return success("TradePackage", ValidationType.CARDINALITY, "TradePackage", path, "");
			})
			.collect(toList());
	}

}
