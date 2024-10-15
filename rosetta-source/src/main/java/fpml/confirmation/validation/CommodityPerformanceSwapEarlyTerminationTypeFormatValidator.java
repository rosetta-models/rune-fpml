package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPerformanceSwapEarlyTerminationTypeFormatValidator implements Validator<CommodityPerformanceSwapEarlyTermination> {

	private List<ComparisonResult> getComparisonResults(CommodityPerformanceSwapEarlyTermination o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPerformanceSwapEarlyTermination> validate(RosettaPath path, CommodityPerformanceSwapEarlyTermination o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPerformanceSwapEarlyTermination", ValidationType.TYPE_FORMAT, "CommodityPerformanceSwapEarlyTermination", path, "", error);
		}
		return success("CommodityPerformanceSwapEarlyTermination", ValidationType.TYPE_FORMAT, "CommodityPerformanceSwapEarlyTermination", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPerformanceSwapEarlyTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPerformanceSwapEarlyTermination", ValidationType.TYPE_FORMAT, "CommodityPerformanceSwapEarlyTermination", path, "", res.getError());
				}
				return success("CommodityPerformanceSwapEarlyTermination", ValidationType.TYPE_FORMAT, "CommodityPerformanceSwapEarlyTermination", path, "");
			})
			.collect(toList());
	}

}
