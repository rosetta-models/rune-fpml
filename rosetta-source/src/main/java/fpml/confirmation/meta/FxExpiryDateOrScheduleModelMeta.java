package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.validation.FxExpiryDateOrScheduleModelTypeFormatValidator;
import fpml.confirmation.validation.FxExpiryDateOrScheduleModelValidator;
import fpml.confirmation.validation.exists.FxExpiryDateOrScheduleModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxExpiryDateOrScheduleModel.class)
public class FxExpiryDateOrScheduleModelMeta implements RosettaMetaData<FxExpiryDateOrScheduleModel> {

	@Override
	public List<Validator<? super FxExpiryDateOrScheduleModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxExpiryDateOrScheduleModel>create(fpml.confirmation.validation.datarule.FxExpiryDateOrScheduleModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxExpiryDateOrScheduleModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxExpiryDateOrScheduleModel> validator() {
		return new FxExpiryDateOrScheduleModelValidator();
	}

	@Override
	public Validator<? super FxExpiryDateOrScheduleModel> typeFormatValidator() {
		return new FxExpiryDateOrScheduleModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxExpiryDateOrScheduleModel, Set<String>> onlyExistsValidator() {
		return new FxExpiryDateOrScheduleModelOnlyExistsValidator();
	}
}
