package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFrequencyType;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFrequencyTypeTypeFormatValidator implements Validator<CommodityFrequencyType> {

	private List<ComparisonResult> getComparisonResults(CommodityFrequencyType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("commodityFrequencyTypeScheme", o.getCommodityFrequencyTypeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<CommodityFrequencyType> validate(RosettaPath path, CommodityFrequencyType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFrequencyType", ValidationType.TYPE_FORMAT, "CommodityFrequencyType", path, "", error);
		}
		return success("CommodityFrequencyType", ValidationType.TYPE_FORMAT, "CommodityFrequencyType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFrequencyType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFrequencyType", ValidationType.TYPE_FORMAT, "CommodityFrequencyType", path, "", res.getError());
				}
				return success("CommodityFrequencyType", ValidationType.TYPE_FORMAT, "CommodityFrequencyType", path, "");
			})
			.collect(toList());
	}

}
