package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityInformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityInformationSourceTypeFormatValidator implements Validator<CommodityInformationSource> {

	private List<ComparisonResult> getComparisonResults(CommodityInformationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("rateSourcePageHeading", o.getRateSourcePageHeading(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<CommodityInformationSource> validate(RosettaPath path, CommodityInformationSource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityInformationSource", ValidationType.TYPE_FORMAT, "CommodityInformationSource", path, "", error);
		}
		return success("CommodityInformationSource", ValidationType.TYPE_FORMAT, "CommodityInformationSource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityInformationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityInformationSource", ValidationType.TYPE_FORMAT, "CommodityInformationSource", path, "", res.getError());
				}
				return success("CommodityInformationSource", ValidationType.TYPE_FORMAT, "CommodityInformationSource", path, "");
			})
			.collect(toList());
	}

}
