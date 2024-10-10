package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeAlterationPaymentModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeAlterationPaymentModelTypeFormatValidator implements Validator<TradeAlterationPaymentModel> {

	private List<ComparisonResult> getComparisonResults(TradeAlterationPaymentModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeAlterationPaymentModel> validate(RosettaPath path, TradeAlterationPaymentModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeAlterationPaymentModel", ValidationType.TYPE_FORMAT, "TradeAlterationPaymentModel", path, "", error);
		}
		return success("TradeAlterationPaymentModel", ValidationType.TYPE_FORMAT, "TradeAlterationPaymentModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeAlterationPaymentModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeAlterationPaymentModel", ValidationType.TYPE_FORMAT, "TradeAlterationPaymentModel", path, "", res.getError());
				}
				return success("TradeAlterationPaymentModel", ValidationType.TYPE_FORMAT, "TradeAlterationPaymentModel", path, "");
			})
			.collect(toList());
	}

}
