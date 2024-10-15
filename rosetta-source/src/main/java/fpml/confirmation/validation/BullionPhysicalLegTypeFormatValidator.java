package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BullionPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BullionPhysicalLegTypeFormatValidator implements Validator<BullionPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(BullionPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BullionPhysicalLeg> validate(RosettaPath path, BullionPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BullionPhysicalLeg", ValidationType.TYPE_FORMAT, "BullionPhysicalLeg", path, "", error);
		}
		return success("BullionPhysicalLeg", ValidationType.TYPE_FORMAT, "BullionPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BullionPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BullionPhysicalLeg", ValidationType.TYPE_FORMAT, "BullionPhysicalLeg", path, "", res.getError());
				}
				return success("BullionPhysicalLeg", ValidationType.TYPE_FORMAT, "BullionPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
