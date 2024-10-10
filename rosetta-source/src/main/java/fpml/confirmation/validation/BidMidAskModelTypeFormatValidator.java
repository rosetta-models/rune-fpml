package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BidMidAskModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BidMidAskModelTypeFormatValidator implements Validator<BidMidAskModel> {

	private List<ComparisonResult> getComparisonResults(BidMidAskModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BidMidAskModel> validate(RosettaPath path, BidMidAskModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BidMidAskModel", ValidationType.TYPE_FORMAT, "BidMidAskModel", path, "", error);
		}
		return success("BidMidAskModel", ValidationType.TYPE_FORMAT, "BidMidAskModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BidMidAskModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BidMidAskModel", ValidationType.TYPE_FORMAT, "BidMidAskModel", path, "", res.getError());
				}
				return success("BidMidAskModel", ValidationType.TYPE_FORMAT, "BidMidAskModel", path, "");
			})
			.collect(toList());
	}

}
