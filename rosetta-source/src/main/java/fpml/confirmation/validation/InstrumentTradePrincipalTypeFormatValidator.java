package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InstrumentTradePrincipal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentTradePrincipalTypeFormatValidator implements Validator<InstrumentTradePrincipal> {

	private List<ComparisonResult> getComparisonResults(InstrumentTradePrincipal o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InstrumentTradePrincipal> validate(RosettaPath path, InstrumentTradePrincipal o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentTradePrincipal", ValidationType.TYPE_FORMAT, "InstrumentTradePrincipal", path, "", error);
		}
		return success("InstrumentTradePrincipal", ValidationType.TYPE_FORMAT, "InstrumentTradePrincipal", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentTradePrincipal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentTradePrincipal", ValidationType.TYPE_FORMAT, "InstrumentTradePrincipal", path, "", res.getError());
				}
				return success("InstrumentTradePrincipal", ValidationType.TYPE_FORMAT, "InstrumentTradePrincipal", path, "");
			})
			.collect(toList());
	}

}
