package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractTradingAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractTradingAccrualTypeFormatValidator implements Validator<AbstractTradingAccrual> {

	private List<ComparisonResult> getComparisonResults(AbstractTradingAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AbstractTradingAccrual> validate(RosettaPath path, AbstractTradingAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractTradingAccrual", ValidationType.TYPE_FORMAT, "AbstractTradingAccrual", path, "", error);
		}
		return success("AbstractTradingAccrual", ValidationType.TYPE_FORMAT, "AbstractTradingAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractTradingAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractTradingAccrual", ValidationType.TYPE_FORMAT, "AbstractTradingAccrual", path, "", res.getError());
				}
				return success("AbstractTradingAccrual", ValidationType.TYPE_FORMAT, "AbstractTradingAccrual", path, "");
			})
			.collect(toList());
	}

}
